public enum Status {
    // Although enum is a special keywords, but actually it is a class too but for constant.
    // It means that the NOT_DONE enum constant will store "Not_done" as its value;
    // 便于后面的引用；this.status=status.NOT_DONE
    NOT_DONE("Not_done"),
    IN_PROGRESS("In_Progress"),
    DONE("Have Done");

    private final String value;

    Status(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    @Override
    public String toString(){
        return value;
    }
}
