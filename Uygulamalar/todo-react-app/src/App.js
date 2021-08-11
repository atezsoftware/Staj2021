import React, { useState } from "react";
import "./App.css";
import TodoInput from "./Components/TodoInput/TodoInput";
import TodoItem from "./Components/TodoItem/TodoItem";

function App() {
  const [task, setTask] = useState("");
  const [taskList, setTaskList] = useState([]);

  const handleSubmit = (event) => {
    event.preventDefault();
    const isTask = taskList.find((item) => item.task === task);
    const newTask = {
      task: task,
    };
    if (task === "") return;
    if (!isTask) {
      setTaskList((old) => [...old, newTask]);
      setTask("");
    } else {
      alert("böyle bir task var.");
    }
  };

  const handleChange = (event) => {
    if (event !== undefined) setTask(event.target.value);
  };

  const handleRemove = (item) => {
    const neWtaskList = taskList.filter((e) => e.task !== item.task);
    setTaskList(neWtaskList);
  };

  return (
    <div className="appContainer">
      <TodoInput
        value={task}
        handleSubmit={handleSubmit}
        handleChange={handleChange}
      />
      <ul className="taskList_ul">
        {taskList?.map((item, index) => (
          <TodoItem key={index} task={item} handleRemove={handleRemove} />
        ))}
      </ul>
    </div>
  );
}

export default App;
