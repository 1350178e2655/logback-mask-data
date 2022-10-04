- To ovverride message before passing to pattern, developer can extends MessageConverter 
- Regex Patterns are combined and compile once, the code is not looping on the entire list of regex patterns
 
-   user.put("msgId", "P01234567891231123456789");  <maskPattern>\"msgId\"\s*:\s*\"(.*?)\d{13}\"</maskPattern>  / "msgId":"***********1231123456789"
    
