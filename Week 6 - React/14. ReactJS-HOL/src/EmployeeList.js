import React from 'react';
import EmployeeCard from './EmployeeCard';

function EmployeeList() {
  return (
    <div>
      <h1>Employees List</h1>

      <EmployeeCard
        name="Jojo"
        email="jojo@congizant.com"
        phone="98238971234"
      />

      <EmployeeCard
        name="Sam"
        email="sam@congizant.com"
        phone="9981184126"
      />

      <EmployeeCard
        name="Elisa"
        email="elisa@cognizant.com"
        phone="9989389735"
      />
    </div>
  );
}

export default EmployeeList;