class Solution {
    public boolean isValid(String s) {
        
      
        java.util.Stack<Character> stack = new java.util.Stack<>();
        
     
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
           
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            
            else {
                
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
        
                if (ch == ')' && top != '(') {
                    return false;
                }
                if (ch == '}' && top != '{') {
                    return false;
                }
                if (ch == ']' && top != '[') {
                    return false;
                }
            }
        }
        
        
        return stack.isEmpty();
    }
}