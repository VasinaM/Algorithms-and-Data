package Stack;
//проверка алгебраического выражения на правильную скобочную последовательность

public class Expression {
    private String expr;

    public Expression(String expr){
        this.expr = expr;
    }

    public boolean checkBreckets (){
        MyArrayStack<Character> stack = new MyArrayStack<>();
        for (int i = 0; i < expr.length(); i++) {
            Character c = expr.charAt(i);
            if(c.equals('(') || c.equals('[') || c.equals('{')){
                stack.push(c);
            }
            else if (c.equals(')') || c.equals(']') || c.equals('}')){
                if (stack.isEmpty()){
                    return  false;
                }
                Character top = stack.pop();
                if (top.equals('(') && !c.equals(')') || top.equals('[') && !c.equals(']') ||
                        top.equals('{') && !c.equals('}')) {
                    return  false;
                }
            }
        }
        return stack.isEmpty();
    }
}
