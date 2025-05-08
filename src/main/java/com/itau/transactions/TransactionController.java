package com.itau.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/statistics")
    public ResponseEntity<TransactionStats> getStatistics() {
        TransactionStats stats = transactionService.calculateStatistics();
        return ResponseEntity.ok(stats);
    }
}


//código finalizado, agora é só esperar os bugs aparecerem
  //Fe – o dev mestre dos bugs
  
  /*
       ,--./,-.        </ >ˆ$
      / #      /
     |       |
      \        \
       `._,._,'
  */
