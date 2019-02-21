package edu.cnm.deepdive.diceware.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassphraseGenerator implements Generator {

  private List<String> words;
  private Random rng;

  @Autowired
  public PassphraseGenerator(WordSource words, Random rng) {
    this.words = new ArrayList<>(
        words.getWords()); // ArrayList is good for access by index.
    this.rng = rng;
  }

  @Override
  public String[] generate(int length) {
    String[] passphrase = new String[length];
    for (int i = 0; i < passphrase.length; ++i) {
      passphrase[i] = words.get(rng.nextInt(words.size()));
    }
    return passphrase;
  }

}
