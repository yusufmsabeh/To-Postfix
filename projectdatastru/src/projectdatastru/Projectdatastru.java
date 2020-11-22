
package projectdatastru;
import javax.swing.*;

public class Projectdatastru {

    
    public static void main(String[] args) {
        char []top = {'*','/','%'};
        char [] lower = {'-','+'};
        String statment = new String();
        statment=JOptionPane.showInputDialog("Enter the expression:");
        StringBuilder stack = new StringBuilder();
        StringBuilder outputstream = new StringBuilder();
        
       
        for(int i=0;i<statment.length();){
            System.out.println(statment.charAt(i));
            
            if(Character.isLetter(statment.charAt(i))||Character.isDigit(statment.charAt(i))){
                outputstream.append(statment.charAt(i));
                System.out.println("if1 cheak it is a char");
                i++;
            }
            else{
                System.out.println("else1 cheak it is an op");
                System.out.println(statment.charAt(i));
                if(stack.length()==0){
                    stack.append(statment.charAt(i));
                    System.out.println("if2 cheak it is empty");
                    i++;
            }
                else {
                    System.out.println("else2 cheak it is an op");
                    System.out.println(statment.charAt(i));
                    int p =0;
                    int s=0;
                    if(statment.charAt(i)==top[0]||statment.charAt(i)==top[1]||statment.charAt(i)==top[2]){
                      p=1;
                        System.out.println("cheak top or low 1");
                    }
                    else if(statment.charAt(i)==lower[0]||statment.charAt(i)==lower[1]){
                    p=2;
                    System.out.println("cheak top or low 2");
                    }
                    if(stack.charAt(stack.length()-1)==top[0]||stack.charAt(stack.length()-1)==top[1]||stack.charAt(stack.length()-1)==top[2]){
                       s=1;
                       System.out.println("cheak top or low 3");
                       System.out.println(statment.charAt(i));
                    }
                    else if(stack.charAt(stack.length()-1)==lower[0]||stack.charAt(stack.length()-1)==lower[1]){
                        s=2;
                        System.out.println("cheak top or low 4");
                    }
                    if(p==2&&s==1 || p==s&&p!=0&&s!=0){
                    outputstream.append(stack.charAt(stack.length()-1));
                    stack.deleteCharAt(stack.length()-1);
                    System.out.println("poop and push to output stream"); 
                    }
                    
                    else if ((p==1&&s==2) || stack.charAt(stack.length()-1)=='(' || stack.charAt(stack.length()-1)=='['){
                        stack.append(statment.charAt(i));
                        System.out.println("push to stack");
                        i++;
                    }
                    else if(statment.charAt(i)=='^'){
                        stack.append(statment.charAt(i));
                        System.out.println("push to stack ^^ ");
                        i++;
                    }
                    else {
                        System.out.println("cheak face a(or[");
                        if(statment.charAt(i)=='('||statment.charAt(i)=='['){
                            stack.append(statment.charAt(i));
                            System.out.println("cheak it is a open ( [");
                            i++;
                        }
                        else{
                            if(statment.charAt(i)==')'){
                                StringBuilder temp = new StringBuilder(); 
                                temp.append(stack.substring(stack.indexOf("(")+1));
                               
                                System.out.println(temp.reverse());
                                outputstream.append(temp.reverse());
                                stack.delete(stack.indexOf("("),stack.length());
                                System.out.println("cheak it is a close )");
                                i++;
                            }
                            else if(statment.charAt(i)==']'){
                                StringBuilder temp = new StringBuilder(); 
                                temp.append(stack.substring(stack.indexOf("[")+1));
                               
                                System.out.println(temp.reverse());
                                outputstream.append(temp.reverse());
                                stack.delete(stack.indexOf("["),stack.length());
                                System.out.println("cheak it is a close ]");
                                i++;
                            }
                            
                        }
                    
                    
                }
              
               
        }
        
    }
            System.out.println(stack+"&&&&&&"+outputstream);
}
    
     
    JOptionPane.showMessageDialog(null, outputstream+""+stack.reverse());
    }
}
