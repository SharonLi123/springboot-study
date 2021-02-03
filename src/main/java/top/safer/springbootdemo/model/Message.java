package top.safer.springbootdemo.model;

import lombok.Data;

@Data
public class Message {
    private Long id;
    private String text;
    private String summary;
}
