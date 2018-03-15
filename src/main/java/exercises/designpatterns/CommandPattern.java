package exercises.designpatterns;

public class CommandPattern {
    interface ProcessCommand <C>{
        void process(C command);
    }

    class DeleteCommandProcessor implements ProcessCommand<DeleteCommand>{

        @Override
        public void process(DeleteCommand command) {
            command.execute();
        }
    }

    class CopyCommandProcessor implements ProcessCommand<CopyCommand>{

        @Override
        public void process(CopyCommand command) {
            command.execute();
        }
    }


    private class DeleteCommand implements Command{

        @Override
        public void execute() {
            System.out.println("deleted");
        }
    }

    private class CopyCommand implements Command{

        @Override
        public void execute() {
            System.out.println("copied");
        }
    }


    private interface Command {
        public void execute() ;
    }

    public static void main(String[] args) {

    }

}
