import React from 'react';
import { StatusBar } from 'expo-status-bar';
import { useFonts } from 'expo-font';
import { StyleSheet, View } from 'react-native';
import Login from './screens/Login';
import Inicio from './screens/Inicio';

export default function App() {


  return (
    <View>
      <Inicio />
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({

});
