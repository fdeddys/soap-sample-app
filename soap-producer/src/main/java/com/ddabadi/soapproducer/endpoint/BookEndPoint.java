package com.ddabadi.soapproducer.endpoint;

import com.ddabadi.soapproducer.repository.BookRepository;
import com.ddabadi.soapproducer.services.booksvc.AddBookRequest;
import com.ddabadi.soapproducer.services.booksvc.AddBookResponse;
import com.ddabadi.soapproducer.services.booksvc.GetBookRequest;
import com.ddabadi.soapproducer.services.booksvc.GetBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BookEndPoint {
// com.ddabadi...booksvc
    private static final String NAMESPACE_URI = "http://com/ddabadi/soapproducer/services/bookSvc";

    private BookRepository bookRepository;

    @Autowired
    public BookEndPoint(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // To handle getBookRequest
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookRequest")
    @ResponsePayload
    public GetBookResponse getBook(@RequestPayload GetBookRequest request) {
        GetBookResponse response = new GetBookResponse();
        response.setBook(bookRepository.findBook(request.getName()));

        return response;
    }

    // To handle addBookRequest
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addBookRequest")
    @ResponsePayload
    public AddBookResponse addBook(@RequestPayload AddBookRequest request) {
        AddBookResponse response = new AddBookResponse();
        bookRepository.addBook(request.getBook());
        response.setStatus("SUCCESS");
        return response;
    }
}
