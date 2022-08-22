import React from "react";
import { container, Navbar, Nav, Button } from "react-bootstrap";
import styled from "styled-components";
let BtnColor = styled.button`
  background: ${(props) => props.bgc};
  color: ${(pros) => (props.bgc === "yellow" ? "black" : "white")};
  padding: 5px;
`;
function BootStrapApp(props) {
  return (
    <>
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="#home">Navbar</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="#home">Home</Nav.Link>
            <Nav.Link href="#features">Features</Nav.Link>
            <Nav.Link href="#pricing">Pricing</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      <Button>Home</Button>
      <BtnColor bgc="yellow">Home</BtnColor>
      <BtnColor bgc="black">Home</BtnColor>
      <BtnColor bgc="red">Home</BtnColor>
    </>
  );
}

export default Bootstrap;
