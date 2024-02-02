package duke;

import duke.exception.CommandInvalidException;
import duke.task.Task;
import java.util.ArrayList;

public class TaskList {

    /**
     * Constructor for the TaskList.
     *
     */
    private ArrayList<Task> tasks;
    public TaskList(){
        tasks = new ArrayList<>();
    }

    /**
     * Constructor for the TaskList.
     *
     * @param t An ArrayList of task.
     */
    public TaskList(ArrayList<Task> t){
        tasks = t;
    }

    /**
     * Returns a string if the task given is
     * succesfully added.
     *
     * @param t a task to be added.
     * @return a string.
     */
    public String addTask(Task t) {
        tasks.add(t);
        String a = "Got it. I've added this task:\n";
        String b = tasks.get(tasks.size()-1).toString() + "\n";
        String c = "Now you have " + tasks.size() + " tasks in the list.";
        return a + b + c;
    }

    /**
     * Returns a string if the task with the given
     * number is succesfully marked.
     *
     * @param n task number.
     * @return a string.
     */
    public String mark(int n) {
        tasks.get(n).setMark();
        String a = "Nice! I've marked this task as done:\n";
        String b = tasks.get(n).toString();
        return a + b;
    }

    /**
     * Returns a string if the task with the given
     * number is succesfully unmarked.
     *
     * @param n task number.
     * @return a string.
     */
    public String unMark(int n) {
        tasks.get(n).setUnMark();
        String a = "OK, I've marked this task as not done yet:\n";
        String b = tasks.get(n).toString();
        return a + b;
    }

    /**
     * Returns a string if the task with the given
     * number is succesfully deleted.
     *
     * @param n task number.
     * @return a string.
     */
    public String delete(int n) {
        Task delT = tasks.get(n);
        tasks.remove(n);
        String a = "Noted. I've removed this task:\n";
        String b = delT.toString() + "\n";
        String c = "Now you have " + tasks.size() + " tasks in the list. ";
        return a + b + c;
    }

    /**
     * Returns an ArrayList of task from the TaskList.
     *
     * @return an ArrayList of task.
     */
    public ArrayList<Task> getList(){
        return tasks;
    }

    /**
     * Returns the current list of task in String format.
     *
     */
    public String showList() {
        String sl = "";
        for (int i = 0; i < tasks.size(); i++) {
            sl = sl + (i+1) + "." + tasks.get(i).toString() + "\n";
        }
        return sl;
    }

    /**
     * Returns all the tasks that contains the key in
     * String format.
     *
     * @param key the string key need to be contained.
     * @return the list of tasks that contains key in String format.
     */
    public String findList(String key) {
        String sl = "";
        int no = 1;
        for (int i = 0 ; i < tasks.size(); i++) {
            if (tasks.get(i).hasFind(key)) {
                sl = sl + no + "." + tasks.get(i).toString() + "\n";
                no++;
            }
        }
        if (sl.equals("")) {
            sl = "Not found task with keyword: " + key;
        }
        return sl;
    }
}
