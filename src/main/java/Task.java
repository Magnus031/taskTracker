import java.util.UUID;

public class Task {
    // Here are 3 information for one task storing in the JSON ;
    private String id;
    private String description;
    private Status status;
    // constructor function to register a new task;
    public  Task(String description){
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.status = Status.NOT_DONE;
    }

    public String getJSON(){
        // Actually {"id":"hello", "description":"", "status":""}
        return "{\"id\":\""+id.strip()+"\", \"description\":\"" + description.strip()
                +"\", \"status\":\""+status.toString()+"\"}";
    }



    public static Task fromJSON(String Json){
        // We split the JSON String into some fragments;
        String[] JS = Json.replace("{","").replace("\"","").
                replace("}","").replace(":",",").split(",");
        String description = JS[3];

        // Construct a Task Objects;
        Task result = new Task(description);
        result.setId(JS[1]);
        String status = JS[5];

        if(status.equals("In_Progress")){
            result.markProgress();
        }else if(status.equals("Done")){
            result.markDone();
        }
        return result;
    }

    public String getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public Status getStatus(){
        return status;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Used to record the status of the task;
     */
    public void markDone(){
        this.status = Status.DONE;
    }

    public void markProgress(){
        this.status = Status.IN_PROGRESS;
    }

}
