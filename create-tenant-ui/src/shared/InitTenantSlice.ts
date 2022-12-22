import { createSlice } from "@reduxjs/toolkit";

const SLICE_NAME = "initTenant"

export type Account = {
  gender: string, firstname: string, lastname: string, email: string, password: string, locale: string
};

const initialState: Account = {
  gender: "",
  firstname: "",
  lastname: "",
  email: "",
  password: "",
  locale: ""

};
const initTenantSlice = createSlice( {
  name: SLICE_NAME,
  initialState,
  reducers: {
    setGender: (state, action) => {
      state.gender = action.payload
    },
    setFirstname: (state, action) => {
      state.firstname = action.payload
    },
    setLastname: (state, action) => {
      state.lastname = action.payload
    },
    setEmail: (state, action) => {
      state.email = action.payload
    },
    setPassword: (state, action) => {
      state.password = action.payload
    },
    setLocale: (state, action) => {
      state.locale = action.payload
    },
  }
} );

export const {
  setGender,
  setFirstname,
  setLastname,
  setEmail,
  setPassword,
  setLocale
} = initTenantSlice.actions;

export default initTenantSlice.reducer;