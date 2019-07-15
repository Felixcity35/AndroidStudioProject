package com.idee.wordoffaithcovenantassemblyapplication.data;

public class PastorMessageModel
{

   private String image ;
   private String topic ;
    private String message ;
    private String timestamp ;



    public PastorMessageModel(String image, String topic, String message,String timestamp) {
        this.image = image;
        this.topic = topic;
        this.message = message;
        this.timestamp = timestamp ;
    }

    public String getImage() {
        return image ;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "PastorMessageModel{" +
                "image='" + image + '\'' +
                ", topic='" + topic + '\'' +
                ", message='" + message + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
