public class TodoList {
    public static String[] model = new String[5];
    // Membuat object scanner untuk meminta inputan dari user
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        testView();
    }

    public static void showTodoList() {
        for(int index = 0; index < model.length; index++) {
            var todo = model[index];

            if(todo == null) {
                continue;
            }

            var number = index + 1;

            System.out.println(number + ". " + todo);
        }
    }

    public static void addTodoList(String todo) {
        boolean isFull = true;

        for(var i = 0; i < model.length; i++) {
            if(model[i] == null) {
                isFull = false;
                break;
            }
        }

        if(isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for(var i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        for(int i = 0; i < model.length; i++) {
            if(model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static boolean removeTodoList(int no) {
        if((no - 1) >= model.length) {
            return false;
        } else if(model[no - 1] == null) {
            return false;
        } else {
            for(var i = (no - 1); i < model.length; i++) {
                if(i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public  static String input(String question) {
        System.out.print(question);
        // Menrima inputan dari user (ini akan menghasilkan inputan dari user berupa string)
        return scanner.nextLine();
    }

    public static void viewShowTodoList() {
        System.out.println("Todo List Application");
        showTodoList();
    }

    public static void testViewShowTodoList() {
        addTodoList("Sowon");
        addTodoList("Yerin");
        viewShowTodoList();
    }

    public static void viewAddTodoList() {
        String action = input("Todo (x untuk keluar) :");
        addTodoList(action);
        showTodoList();
    }

    public static void testViewAddTodoList() {
        viewAddTodoList();
    }

    public static void viewRemoveTodoList() {
        String number = input("Remove todo (x untuk keluar) : ");

        if(!number.equals("x")) {
            // Convert string jadi number
            removeTodoList(Integer.valueOf(number));
        }

        showTodoList();
    }

    public static void testViewRemoveTodoList() {
        addTodoList("Javascript");
        addTodoList("Python");
        addTodoList("Typescript");

        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }

    public static void testView() {
        testViewShowTodoList();
        while (true) {
            System.out.println("Menu :");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var answer = input("Action  (x untuk keluar ):");

            if(answer.equals("1")) {
                viewAddTodoList();
            } else if(answer.equals("2")) {
                viewRemoveTodoList();
            } else if(answer.equals("x")) {
                break;
            } else {
                System.out.println("Menu tidak di kenali");
            }
        }
    }
}