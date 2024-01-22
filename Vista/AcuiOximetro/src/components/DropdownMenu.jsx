import React, { useState } from 'react'
import { View, Text, StyleSheet, Pressable } from 'react-native'
import Icons from '@expo/vector-icons/FontAwesome'

const DropdownMenu = ({ title, data }) => {
  const [open, setOpen] = useState(false)
  const [rotate, setRotate] = useState(0)
  const [text, setText] = useState(title)

  const touch = () => {
    setRotate(rotate === 90 ? 0 : 90)
    setOpen(!open)
  }

  const changeTitle = (newTitle) => {
    setText(newTitle)
  }

  const renderOptions = () => {
    if (open) {
      return (
        <View style={styles.main}>
          {data?.map((item, index) => (
            <Pressable
              key={index} onPress={() => {
                changeTitle(item)
                touch()
              }} style={styles.container}
            >
              <Text style={styles.text}>{item}</Text>
            </Pressable>
          ))}
        </View>
      )
    }
  }

  return (
    <View style={styles.main}>
      <View style={styles.container}>
        <Pressable style={styles.containerMenu} onPress={touch}>
          <Icons
            name='chevron-right'
            size={10}
            color='#000'
            style={{ transform: [{ rotate: `${rotate}deg` }] }}
          />
          <Text style={styles.text}>{text}</Text>
        </Pressable>
      </View>
      {renderOptions()}
    </View>
  )
}

const styles = StyleSheet.create({
  main: {
    gap: 10
  },
  container: {
    backgroundColor: '#FFF',
    height: 50,
    paddingVertical: 15,
    paddingHorizontal: 10,
    borderWidth: 1,
    borderRadius: 5
  },
  containerMenu: {
    alignItems: 'center',
    flexDirection: 'row',
    gap: 10
  },
  text: {
    textAlign: 'center',
    fontSize: 15
  }
})

export default DropdownMenu
