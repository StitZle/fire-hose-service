import React, { useState } from "react";
import { Button, Center, Col, createStyles, Grid, Group, Stepper, Text, Title } from "@mantine/core";
import CreateAccountStep from "./CreateAccountStep";
import SelectRoleStep from "./SelectRoleStep";
import CreateSpaceStep from "./CreateSpaceStep";


const useStyles = createStyles( (theme) => ({
  wrapper: {
    padding: `${theme.spacing.xl * 2}px ${theme.spacing.xl}px`,
  },

  stepper: {
    separator: {
      minHeight: 250
    }
  },

  stepperWrapper: {
    height: "100%",
    border: 5,
  },

  createWrapper: {
    minWidth: "100%"
  }
}) );

const TenantCreateService = () => {

  const { classes } = useStyles();

  const [step, setStep] = useState( 0 );


  const nextStep = () => {
    setStep( step + 1 )
  }

  const previousStep = () => {
    setStep( step - 1 )
  }

  const buttons = () => {
    return (<Group>
      <Button variant="default" onClick={() => previousStep()}>Previous</Button>
      <Button onClick={() => nextStep()}>Next</Button>
    </Group>)
  }


  //https://github.com/mantinedev/mantine/pull/3188
  return (

  <Grid gutter={80}>
    <Col span={12} md={5}>
      <Stepper active={step} onStepClick={nextStep} orientation="vertical">
        <Stepper.Step label="Step 1" description="Admin anlegen"/>
        <Stepper.Step label="Step 2" description="Space anlegen"/>
        <Stepper.Step label="Step 3" description="Rolle wählen"/>
        <Stepper.Step label="Step 4" description="Überprüfen"/>
      </Stepper>
    </Col>
    <Col span={12} md={7}>
      {step == 0 &&  <CreateAccountStep/>}
      {step == 1 &&    <CreateSpaceStep/>}
      {step == 2 &&    <SelectRoleStep/>}
      {step == 3 &&    <h1>Step 4</h1>}

      <Group>
        <Button variant="default" onClick={() => previousStep()}>Previous</Button>
        <Button onClick={() => nextStep()}>Next</Button>
      </Group>
    </Col>
  </Grid>
  );
}

export default TenantCreateService;