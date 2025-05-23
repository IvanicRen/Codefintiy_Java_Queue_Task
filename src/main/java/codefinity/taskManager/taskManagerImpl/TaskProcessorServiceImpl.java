package codefinity.taskManager.taskManagerImpl;

import codefinity.taskManager.Task;
import codefinity.taskManager.TaskProcessorService;
import codefinity.taskManager.TaskQueueService;

public class TaskProcessorServiceImpl implements TaskProcessorService {
    TaskQueueService taskQueueService;

    public TaskProcessorServiceImpl(TaskQueueService taskQueueService) {
        this.taskQueueService = taskQueueService;
    }

    @Override
    public void processTask() {
        if (!taskQueueService.isEmpty()) {
            Task task_out = taskQueueService.getNextTask();
            System.out.println("Processing Task: " + task_out);
        }
    }

    @Override
    public void processTasks() {
        while (!taskQueueService.isEmpty()) {
            Task task_out = taskQueueService.getNextTask();
            System.out.println("Processing Task: " + task_out);
        }
        System.out.println("All tasks processed.");
    }
}