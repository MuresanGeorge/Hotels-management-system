package spring.demo.dto;

public class EmailDTO {
    private String to;
    private static final String subject = "FeedBack Hotel";
    private static final String text = "Lasa-ne o nota in functie de serviciile oferite";

    public EmailDTO(String to) {
        this.to = to;
    }
    public EmailDTO(){}

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public static String getSubject() {
        return subject;
    }

    public static String getText() {
        return text;
    }
}
