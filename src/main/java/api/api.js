// App.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const App = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    const fetchUsers = async () => {
      try {
        const response = await axios.get('/api/users');
        setUsers(response.data);
      } catch (error) {
        console.error('Error fetching users:', error);
      }
    };
    fetchUsers();
  }, []);

  return (
    <div className="App">
      <h1>Social Media Analytics Dashboard</h1>
      <div className="user-list">
        {users.map(user => (
          <div key={user.id} className="user-card">
            <h2>{user.name}</h2>
            <p>{user.bio}</p>
            <p>Category: {user.category}</p>
            {/* Add more fields as needed */}
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
