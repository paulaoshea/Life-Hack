
public class Task  {
	
	private String whoseTask;
	private String taskDetail;
	private boolean complete;


	public Task(String whoseTask, String taskDetail, boolean complete) {
		this.whoseTask = whoseTask;
		this.taskDetail = taskDetail;
		this.complete = complete;
	}
	
	public String getWhoseTask() {
		return whoseTask;
	}

	public void setWhoseTask(String whoseTask) {
		this.whoseTask = whoseTask;
	}
	
	public String getTaskDetail() {
		return taskDetail;
	}

	public void setTaskDetail(String taskDetail) {
		this.taskDetail = taskDetail;
	}

	public boolean getCompete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public boolean isComplete() {
		return complete;
	}
	
	@Override
	public String toString() {
		return taskDetail + " " + complete + " " + whoseTask;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Task) {
			Task otherTask = (Task) obj;
			
			String otherWhoseTask = otherTask.getWhoseTask();
			String otherTaskDetail = otherTask.getTaskDetail();
			
			if(whoseTask==otherWhoseTask && taskDetail.equalsIgnoreCase(otherTaskDetail)) {
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
		
	}
}
