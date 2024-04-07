package oy.tol.tra;


public class ParenthesisChecker {

   private ParenthesisChecker() {
   }

  
    public static int checkParentheses(StackInterface<Character> stack, String fromString) throws ParenthesesException {
    
      stack.push('1');

      int n = 0;
      for(int i=0;i< fromString.length(); i++ ){
         
         char a = fromString.charAt(i);
         if(a=='('|| a == '[' ||a == '{'){
            stack.push(a);
            n++;
         }else if(a==')' ||a==']'||a=='}'){
            n++;
            char b = '0';
            b = stack.pop();

            if( b== '1' ){
               throw new ParenthesesException("too many closing parentheses", -1);
            }
            else 
            if((a==')' &&  b!='(' ) || (a==']' && b != '[') || (a=='}' && b != '{')){
               throw new ParenthesesException("wrong kind of parenthesis", -3);
            }
            
         }

      }
      stack.pop();
      if(!stack.isEmpty()){
         throw new ParenthesesException("more opening than closing parentheses", -2);
      }

      return n;
   }
}
