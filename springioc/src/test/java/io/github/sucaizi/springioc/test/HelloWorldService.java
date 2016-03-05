package io.github.sucaizi.springioc.test;

public class HelloWorldService {
	
    private String text;

    private OutputService outputService;

    public void helloWorld(){
        //outputService.output(text);
    	System.out.println(this.text);
    }
    
    

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }

}
