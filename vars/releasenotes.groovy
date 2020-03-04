import java.io.File;
import groovy.io.FileType;

def call(Map config=[:]){
    def dir = new File(pwd());
    
    echo "******************" + dir.path + "******************";
    
    var writer = new File(dir.path + '\\releasenotes.txt').withWriter('utf-8');
    
    var files = eachFileRecurse(FileType.ANY);
    
    for (file in files){
    	if (file.isDirectory()){
	    writer.writeLine(file.name);            
	}
	else
	{
	    writer.writeLine('\t' + file.name + '\t' + file.length());
	}
    }
}