import { Grid, PasswordInput, Select, TextInput } from "@mantine/core";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../store/store";
import { Account, setFirstname, setGender, setLastname, setEmail, setPassword, setLocale } from "../shared/InitTenantSlice";


const genderData = [{
  value: "MALE",
  label: "Männlich"
}, {
  value: "FEMALE",
  label: "Weiblich"
}, {
  value: "DIVERS",
  label: "Divers"
},];

const localeData = [{
  value: "de_DE",
  label: "Deutsch"
}, {
  value: "en_GB",
  label: "Englisch (GB)"
}, {
  value: "en_US",
  label: "Englisch (US)"
}, {
  value: "fr_FR",
  label: "Französisch"
},]


const CreateAccountStep = () => {

  const account: Account = useSelector( (state: RootState) => state.initTenant );
  const dispatch = useDispatch();

  // @ts-ignore
  return (<Grid gutter="md">
      <Grid.Col span={4}>
        <Select
          placeholder="M"
          label="Gender"
          withAsterisk
          value={account.gender}
          onChange={(item) => dispatch(setGender( item))}
          data={genderData}/>
      </Grid.Col>
      <Grid.Col span={4}>
        <TextInput
          placeholder="Max"
          label="Vorname"
          withAsterisk
          value={account.firstname}
          onChange={(event) => dispatch(setFirstname( event.target.value))}
        />
      </Grid.Col>
      <Grid.Col span={4}>
        <TextInput
          placeholder="Mustermann"
          label="Nachname"
          withAsterisk
          value={account.lastname}
          onChange={(event) => dispatch(setLastname( event.target.value))}
        />
      </Grid.Col>

      <Grid.Col span={6}>
        <TextInput
          placeholder="max@mustermann.de"
          label="E-Mail"
          withAsterisk
          value={account.email}
          onChange={(event) => dispatch(setEmail( event.target.value))}
          error={"THIS IS AN ERROR"}
        />
      </Grid.Col>
      <Grid.Col span={6}>
        <PasswordInput
          label="Password"
          withAsterisk
          value={account.password}
          onChange={(event) => dispatch(setPassword( event.target.value))}
        />
      </Grid.Col>

      <Grid.Col span={6}>
        <Select
          placeholder="Deutsch"
          label="Sprache"
          withAsterisk
          value={account.locale}
          onChange={(item) => dispatch(setLocale( item))}
          data={localeData}/>
      </Grid.Col>
    </Grid>);
}

export default CreateAccountStep;