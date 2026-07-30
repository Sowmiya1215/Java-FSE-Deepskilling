import React, { useState } from "react";

function ComplaintRegister() {
  const [employeeName, setEmployeeName] = useState("");
  const [complaint, setComplaint] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();

    const referenceNumber =
      "REF" + Math.floor(100000 + Math.random() * 900000);

    alert(
      "Complaint registered successfully!\nReference Number: " +
        referenceNumber
    );
  };

  return (
    <div>
      <h2>Complaint Register</h2>

      <form>
        <label>Employee Name:</label>
        <br />

        <input
          type="text"
          value={employeeName}
          onChange={(e) => setEmployeeName(e.target.value)}
        />

        <br />
        <br />

        <label>Complaint:</label>
        <br />

        <textarea
          value={complaint}
          onChange={(e) => setComplaint(e.target.value)}
        ></textarea>

        <br />
        <br />

        <button type="button" onClick={handleSubmit}>
          Submit Complaint
        </button>
      </form>
    </div>
  );
}

export default ComplaintRegister;