import { Grid } from "@mantine/core";

const CreateAccountStep = () => {

  return (
    <Grid>
      <Grid.Col span={4}>Anrede</Grid.Col>
      <Grid.Col span={4}>Vorname</Grid.Col>
      <Grid.Col span={4}>Nachname</Grid.Col>

      <Grid.Col span={6}>E-Mail</Grid.Col>
      <Grid.Col span={6}>Land</Grid.Col>

      <Grid.Col span={6}>Password</Grid.Col>
    </Grid>);
}

export default CreateAccountStep;