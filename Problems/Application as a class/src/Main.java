class Application {

    String name;

    void run(String[] args) {
        // implement me
        System.out.println(name);
        for (String ele: args) {
            System.out.println(ele);
        }
    }
}