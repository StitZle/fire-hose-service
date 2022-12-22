import React, { useState } from 'react'
import { ColorScheme, ColorSchemeProvider, MantineProvider } from "@mantine/core";
import { BrowserRouter } from "react-router-dom";
import TenantCreateService from "./components/TenantCreateService";
import { Provider } from 'react-redux'
import { store } from "./store/store";

function App() {

  const BASE_PATH = "/create-tenant-service";

  //https://mantine.dev/guides/dark-theme/#colorschemeprovider
  //const preferredColorScheme = useColorScheme();
  const [colorScheme, setColorScheme] = useState<ColorScheme>("dark")
  const toggleColorScheme = (value?: ColorScheme) => {
    setColorScheme(value || (colorScheme === "light" ? "dark" : "light"));
  }

  //https://codesandbox.io/s/boring-hawking-3o2ovb?file=/src/App.tsx
  return (
    <React.StrictMode>
      <Provider store={store}>
         <ColorSchemeProvider colorScheme={colorScheme} toggleColorScheme={toggleColorScheme}>
          <MantineProvider theme={{colorScheme}} withGlobalStyles withNormalizeCSS>
            <BrowserRouter basename={BASE_PATH}>
              <TenantCreateService/>
            </BrowserRouter>
          </MantineProvider>
        </ColorSchemeProvider>
      </Provider>
    </React.StrictMode>
  );
}

export default App
