import { Card, createStyles, SimpleGrid, Text, Title } from "@mantine/core";
import React, { useState } from "react";

const useStyles = createStyles( (theme, selected, index) => ({
  card: {
    border: 2,
    borderColor: theme.colors.blue,
    borderStyle: "solid",


    '&:hover': {
      transform: 'scale(1.05)',
      boxShadow: theme.shadows.md,
    },
  },
}) );


const organisations = [
  {
  title: "Feuerwehr",
  description: "This is the Feuerwehr"
},
  {
    title: "Technisches Hilfswerk",
    description: "This is the THW"
  },
  {
    title: "Rettungsdienst",
    description: "This is the Rettungsdienst"
  },
  {
    title: "DLRG",
    description: "This is the DLRG"
  },
  {
    title: "Bergwacht",
    description: "This is the Bergwacht"
  },

];


const CreateAccountStep = () => {

  const {classes} = useStyles();
  const [selected, setSelected] = useState(999);

  const organisationCards = organisations.map((organisation, index) => (
      <Card className={classes.card} shadow="sm" radius="md" withBorder onClick={() => setSelected(index)}>
        <Title order={2}>{organisation.title}</Title>
        <Text size="sm" color="dimmed">
          {organisation.description}
        </Text>
      </Card>
    )
  );

  return (
    <SimpleGrid cols={3}>
      {organisationCards}
    </SimpleGrid>
    );
}

export default CreateAccountStep;