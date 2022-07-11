/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senior_project;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jdk.nashorn.internal.runtime.ParserException;

/**
 *
 * @author Mountafougoumba
 */
public class Tokenizer {
    private class TokenInfo
  {
    public final Pattern regex;
    public final int token;

    public TokenInfo(Pattern regex, int token)
    {
      super();
      this.regex = regex;
      this.token = token;
    }
  }
  
  public class Token
  {
    public final int token;
    public final String sequence;
    
    public Token(int token, String sequence)
    {
      super();
      this.token = token;
      this.sequence = sequence;
    }
    
  }

  private LinkedList<TokenInfo> tokenInfos;
  private LinkedList<Token> tokens;
  
  public Tokenizer()
  {
    tokenInfos = new LinkedList<TokenInfo>();
    tokens = new LinkedList<Token>();
  }
  
  public void add(String regex, int token)
  {
    tokenInfos.add(new TokenInfo(Pattern.compile(regex).compile("^("+regex+")"), token));
  }
  
  public void tokenize(String str)
  {
    String s = str.trim();
    tokens.clear();
    while (!s.equals(""))
    {
      boolean match = false;
      for (TokenInfo info : tokenInfos)
      {
          Matcher m = info.regex.matcher(s);
        if (m.find())
        {
          match = true;
          String tok = m.group().trim();
          s = m.replaceFirst("").trim();
          tokens.add(new Token(info.token, tok));
          break;
        }
      }
      if (!match) throw new ParserException("Unexpected character in input: "+s);
    }
  }
  
  public LinkedList<Token> getTokens()
  {
    return tokens;
  }
    
}
