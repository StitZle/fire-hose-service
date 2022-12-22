import {useAuth0} from "@auth0/auth0-react";
import { Avatar, Text, createStyles, Group, UnstyledButton, Loader, Menu } from "@mantine/core";
import React from "react";
import {IconChevronRight} from "@tabler/icons";

const useStyles = createStyles((theme) => ({
    userInfo: {
      display: 'block',
      padding: theme.spacing.sm,


      '&:hover': {
        backgroundColor: theme.colorScheme === 'dark' ? theme.colors.dark[8] : theme.colors.gray[3],
      },
    }
}));

const UserInfo = () => {

    //https://mantine.dev/core/menu/#custom-component-as-target

    const {classes} = useStyles();
    const {user, isLoading} = useAuth0();

    console.log(user)

    return (
        <>
            {(!isLoading && user) &&
                  <UnstyledButton className={classes.userInfo}>
                    <Group>
                      <Avatar src={user.picture} radius="xl"/>
                      <div style={{flex: 1}}>
                        <Text size="sm" weight={500}>
                          {user.name}
                        </Text>
                        <Text color="dimmed" size="xs">
                          {user.email}
                        </Text>
                      </div>
                      <IconChevronRight size={16}/>
                    </Group>
                  </UnstyledButton>
            }
            {isLoading && <Loader/>}
        </>
    );
};

export default UserInfo;