package com.yunhongmin.objects

class Button : Clickable, Focusable {
    override fun click() = println("Button clicked!")
    override fun setFocus() = println("Button Focused!")
    override fun showOff() = super<Clickable>.showOff()
}
