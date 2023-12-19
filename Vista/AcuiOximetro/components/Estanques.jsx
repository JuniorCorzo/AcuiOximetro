import React from "react";
import { View, Text, Pressable, StyleSheet } from "react-native";
import Icons from "@expo/vector-icons/MaterialIcons";
const Estanques = ({ nombre }) => {
  return (
    <View style={styles.container}>
      <Pressable style={styles.containerImage}>
        <Icons name="image" size={100} color={"#000"} />
      </Pressable>
      <View style={styles.group}>
        <View style={[styles.groupLayout, styles.groupChild]}></View>
        <View style={styles.groupLayout}></View>
        <View style={[styles.groupLayout, styles.groupInner]}></View>
      </View>
      <Text>{nombre}</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    maxWidth: "45%",
    alignItems: "center",
    justifyContent: "center",
    gap: 10,
  },
  containerImage: {
    width: 135,
    height: 135,
    justifyContent: "center",
    alignItems: "center",
    borderWidth: 1,
    borderRadius: 5,
  },
  group: {
    flexDirection: "row",
    gap: 5,
  },
  groupLayout: {
    width: 125 / 3,
    height: 13,
    borderWidth: 1,
  },

  groupChild: {
    borderBottomLeftRadius: 5,
    borderTopLeftRadius: 5,
  },
  groupItem: {},
  groupInner: {
    borderBottomRightRadius: 5,
    borderTopRightRadius: 5,
  },
});

export default Estanques;
