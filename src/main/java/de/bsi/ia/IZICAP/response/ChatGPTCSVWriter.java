package de.bsi.ia.IZICAP.response;

import de.bsi.ia.IZICAP.DTO.ChatGPTResponse;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ChatGPTCSVWriter {

    public void write(ChatGPTResponse response) throws IOException {

//        File file=new File("/chatgpt/data/response.csv");
        File file=new File("chatgpt.csv");
        FileWriter writer=new FileWriter(file,true);
        writer.write(String.format("\n{\n \"question\" : \"%s\",\n \"answer\": \"%s\"\n }",response.getQuestion(),response.getAnswer()));
        writer.close();
    }


}
