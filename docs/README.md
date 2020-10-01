# User Guide
For DukeWars
## Features 
### Add Tasks
Add a task to the current tasklist
#### Types of tasks : 
    todo
    deadline
    event
<br>

### List Tasks
Lists the current tasks and their state.

### Delete Tasks
Delete a task from the task list, ignores completion status

### Complete Tasks
Marks the targeted task as completed. Shown in list command as a tick or cross. 

### Find Tasks
Find tasks in the tasklist. <br>
Searches for instance of word input and returns it in the form of a list.

### Find Tasks by Date
Find tasks in the tasklist in the date input. <br>
Searches for tasks on/before/after the specified date and returns it in the form of a list.
<br> Example usage : `date before 2020-01-01`

### Find Tasks by Time
Find tasks in the tasklist in the time input. <br>
Searches for tasks on/before/after the specified time and returns it in the form of a list.
<br> Example usage : `time on 12:01`

### Save taskList state
__Handled by program__ <br>
Saves the current state of the tasklist to the disk.

### Load saved taskList
__Handled by program__ <br>
Loads the previously written state of the taskList to the current instance. 

## Usage

### `Keyword` - Feature Name in lower case

Insert `keyword` followed by the desired action like 'find' or 'add'.
Example of usage: 

`event project meeting /at Aug 6th 2-4pm`

Expected outcome:

`Got it. I've added this task:` <br>
 `[E][✘]  project meeting  (at: Aug 6th 2-4pm)`
