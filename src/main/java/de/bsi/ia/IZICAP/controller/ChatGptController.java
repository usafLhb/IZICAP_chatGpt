package de.bsi.ia.IZICAP.controller;

import de.bsi.ia.IZICAP.response.ChatGPTCSVWriter;
import de.bsi.ia.IZICAP.DTO.ChatGPTResponse;
import de.bsi.ia.IZICAP.Completion.CompletionRequest;
import de.bsi.ia.IZICAP.Completion.CompletionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.bsi.ia.IZICAP.DTO.FormInputDTO;
import de.bsi.ia.IZICAP.ApiClient.OpenAiApiClient;
import de.bsi.ia.IZICAP.ApiClient.OpenAiApiClient.OpenAiService;

@Controller
public class ChatGptController {
	
	private static final String MAIN_PAGE = "index";
	@Autowired
	private ChatGPTCSVWriter csvService;
	@Autowired
	private ObjectMapper jsonMapper;
	@Autowired
	private OpenAiApiClient client;

	private String chatWithGpt3(String message) throws Exception {
		var completion = CompletionRequest.defaultWith(message);
		var postBodyJson = jsonMapper.writeValueAsString(completion);
		var responseBody = client.postToOpenAiApi(postBodyJson, OpenAiService.GPT_3);
		var completionResponse = jsonMapper.readValue(responseBody, CompletionResponse.class);
		return completionResponse.firstAnswer().orElseThrow();
	}
	
	@GetMapping(path = "/")
	public String index() {
		return MAIN_PAGE;
	}
	
	@PostMapping(path = "/")
	public String chat(Model model, @ModelAttribute FormInputDTO dto) {
		try {
			ChatGPTResponse chatGPTResponse=new ChatGPTResponse();
			String response=chatWithGpt3(dto.prompt());
			model.addAttribute("request", dto.prompt());
			model.addAttribute("response", response);
			chatGPTResponse.setAnswer(response);
			chatGPTResponse.setQuestion(dto.prompt());
			csvService.write(chatGPTResponse);
		} catch (Exception e) {
			model.addAttribute("response", "Error in communication with OpenAI ChatGPT API.");
		}
		return MAIN_PAGE;
	}




}
