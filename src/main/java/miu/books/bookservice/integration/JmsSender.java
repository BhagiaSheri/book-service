package miu.books.bookservice.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import miu.books.bookservice.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(Book book) {
        try {
            //convert book to JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            String bookString = objectMapper.writeValueAsString(book);
            System.out.println("Sending a JMS message:" + bookString);
            jmsTemplate.convertAndSend("book-queue", bookString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
