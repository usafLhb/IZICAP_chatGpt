package de.bsi.ia.IZICAP.DTO;


public class ChatGPTResponse {

    public ChatGPTResponse() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private String question;
    private String answer;


}
