package edu.cnm.deepdive.diceware.controller;

import edu.cnm.deepdive.diceware.service.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diceware")
public class DicewareController {

  private Generator generator;

  @Autowired
  public DicewareController(Generator generator) {
    this.generator = generator;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public String[] get(
      @RequestParam(name = "length", defaultValue = "6", required = false) int length) {
    return generator.generate(length);
  }

  @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
  public String get(
      @RequestParam(name = "length", defaultValue = "6", required = false) int length,
      @RequestParam(name = "delimiter", defaultValue = " ", required = false) String delimiter) {
    return String.join(delimiter, generator.generate(length));
  }

}
