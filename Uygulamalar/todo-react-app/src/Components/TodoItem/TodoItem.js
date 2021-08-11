import React from "react";
import "./TodoItem.css";

export default function TodoItem({ task, handleRemove }) {
  return (
    <li className="todo_list_item">
      <p>{task.task}</p>
      <div className="todo_list_options" onClick={() => handleRemove(task)}>
        <i className="fas fa-times" />
      </div>
    </li>
  );
}
