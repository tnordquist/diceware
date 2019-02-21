package edu.cnm.deepdive.diceware.service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BundleSource implements WordSource {

  private List<String> words;

  @Autowired
  public BundleSource(@Value("${bundle.baseName}")
      String bundleName) {
    words = new LinkedList<>();
    ResourceBundle bundle = ResourceBundle.getBundle(bundleName);
    for (String key : bundle.keySet()) {
      words.add(bundle.getString(key));
    }
  }

  @Override
  public Collection<String> getWords() {
    return words;
  }

}
