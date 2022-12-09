import React, {useState} from 'react'
import {ColorScheme, ColorSchemeProvider, createStyles, MantineProvider} from "@mantine/core";
import {BASE_PATH} from "./router/navigationPaths";
import {Auth0Provider} from "@auth0/auth0-react";
import authJson from "./auth_config.json";
import {BrowserRouter} from "react-router-dom";
import Layout from "./components/layout/Layout";

const useStyles = createStyles((theme) => ({}));

function App() {
    const { classes } = useStyles();


    //https://mantine.dev/guides/dark-theme/#colorschemeprovider
    //const preferredColorScheme = useColorScheme();
    const [colorScheme, setColorScheme] = useState<ColorScheme>("dark")
    const toggleColorScheme = (value?: ColorScheme) => {
        setColorScheme(value || (colorScheme === "light" ? "dark" : "light"));
    }

    const authConfig = {
        domain: authJson.domain,
        clientId: authJson.clientId,
        audience: authJson.audience,
        redirectUri: window.location.href,
    };


    return (
        <React.StrictMode>
            <Auth0Provider {...authConfig}>
                <ColorSchemeProvider colorScheme={colorScheme} toggleColorScheme={toggleColorScheme}>
                    <MantineProvider theme={{colorScheme}} withGlobalStyles withNormalizeCSS>
                        <BrowserRouter basename={BASE_PATH}>
                            <Layout/>
                        </BrowserRouter>
                    </MantineProvider>
                </ColorSchemeProvider>
            </Auth0Provider>
        </React.StrictMode>
    );
}

export default App
