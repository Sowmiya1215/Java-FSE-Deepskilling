import React, { Component } from "react";

class Getuser extends Component {
  constructor(props) {
    super(props);

    this.state = {
      user: null
    };
  }

  componentDidMount() {
    fetch("https://api.randomuser.me/")
      .then((response) => response.json())
      .then((data) => {
        this.setState({
          user: data.results[0]
        });
      });
  }

  render() {
    const { user } = this.state;

    if (!user) {
      return <h2>Loading...</h2>;
    }

    return (
      <div>
        <h2>User Details</h2>

        <p>
          <b>Title:</b> {user.name.title}
        </p>

        <p>
          <b>First Name:</b> {user.name.first}
        </p>

        <img
          src={user.picture.large}
          alt="User"
          width="200"
        />
      </div>
    );
  }
}

export default Getuser;