package org.cp.LLD.fileSystem.models;

public enum Command {
    mkdir,
    read_file,
    write_file,
    exit;

    Command(){

    }

    public static Command of(String cmd){
       for(Command command : Command.values()){
           if(command.toString().equals(cmd)){
               return command;
           }
       }

       return null;
    }
}
