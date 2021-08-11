import React from "react";
import "./TodoInput.css";

export default function TodoInput({ handleSubmit, handleChange, value }) {
  return (
    <form onSubmit={handleSubmit} className="todo_input">
      <input
        type="text"
        onChange={handleChange}
        placeholder="Yeni task ekle..."
        value={value}
      />
      <button type="submit" className="btn btn-default">
        <i className="fas fa-plus" />
      </button>
    </form>
  );
}
