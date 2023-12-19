import React from "react";
import Constants from "expo-constants";
import { View, ScrollView, Text, FlatList, StyleSheet } from "react-native";
import MenuUsuario from "../components/MenuUsuario.jsx";
import Estanques from "../components/Estanques.jsx";

const Inicio = () => {
  return (
    <View style={[styles.header, styles.container]}>
      <MenuUsuario nombre="Angel" isAdmin={true} />
      <ScrollView
        showsVerticalScrollIndicator={false}
        overScrollMode="never"
        contentContainerStyle={{ paddingBottom: 90 }}
      >
        <View style={styles.container}>
          <Text style={styles.title}>Estanques</Text>
          <View style={styles.containerEstanques}>
            {itemData.map((item, index) => (
              <Estanques key={index} nombre={item.nombre} />
            ))}
          </View>
          <View></View>
        </View>
      </ScrollView>
    </View>
  );
};

const styles = StyleSheet.create({
  header: {
    paddingTop: Constants.statusBarHeight + 20,
  },
  container: {
    alignItems: "center",
    justifyContent: "center",
    gap: 20,
  },
  title: {
    fontSize: 25,
  },
  containerEstanques: {
    width: "85%",
    justifyContent: "space-between",
    flexDirection: "row",
    flexWrap: "wrap",
    gap: 40,
  },
});

const itemData = [
  { nombre: "Estanque 1" },
  { nombre: "Estanque 2" },
  { nombre: "Estanque 3" },
  { nombre: "Estanque 4" },
  { nombre: "Estanque 5" },
  { nombre: "Estanque 6" },
  { nombre: "Estanque 6" },
  { nombre: "Estanque 6" },
  { nombre: "Estanque 6" },
  { nombre: "Estanque 6" },
];

export default Inicio;
