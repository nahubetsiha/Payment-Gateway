package com.pm.paymentgateway.controller;

import com.pm.paymentgateway.model.Recipient;
import com.pm.paymentgateway.service.RecipientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/recipient")
public class RecipientController {

    RecipientService recipientService;

    public RecipientController(RecipientService recipientService){
        this.recipientService = recipientService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Recipient>> getAll(){
        return new ResponseEntity<>(recipientService.getAllRecipients(), HttpStatus.OK);
    }

    @GetMapping("/get-one/{recipientId}")
    public ResponseEntity<Recipient> getRecipientById(@PathVariable Long recipientId){
        return new ResponseEntity<>(recipientService.getRecipient(recipientId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Recipient> addRecipient(@RequestBody @Valid Recipient recipient){
        return new ResponseEntity<>(recipientService.addRecipient(recipient), HttpStatus.OK);
    }

    @PutMapping("/edit/{recipientId}")
    public ResponseEntity<Recipient> editRecipient(@RequestBody @Valid Recipient recipient, @PathVariable  Long recipientId){
        return new ResponseEntity<>(recipientService.updateRecipient(recipient, recipientId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{recipientId}")
    public ResponseEntity<Long> deleteRecipient(@PathVariable Long recipientId){
        return new ResponseEntity<>(recipientService.deleteRecipient(recipientId), HttpStatus.OK);
    }
}
