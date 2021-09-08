package com.arcvideo.android.dsl.html

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/9/6
 * @desc:
 * @version: V-1.0.0
 **/
//每个标签
interface Element {
    /**
     * 拼接元素
     * 缩进符
     */
    fun run(builder: StringBuilder, indent: String) {

    }

}

//文本的Element，独立的字符串
class TextElement(val text: String) : Element {
    override fun run(builder: StringBuilder, indent: String) {
        builder.append("$indent$text\n")
    }
}


//HTML
open class Tag(val tagName: String) : Element {

    //每一个元素
    val element = arrayListOf<Element>()

    //元素的属性
    val attributes = hashMapOf<String, String>()
    override fun run(builder: StringBuilder, indent: String) {
        builder.append("$indent<$tagName${renderAttributes()}>\n")

        for (element in element) {
            element.run(builder, "$indent\t\t")
        }
        builder.append("$indent</$tagName>\n")
    }

    fun renderAttributes():String?{
        val builder = StringBuilder()
        for (key in attributes.keys) {
            builder.append(" $key=\"${attributes[key]}\"")
        }
        return builder.toString()
    }
    override fun toString(): String {
        val builder = StringBuilder()
        run(builder,"")
        return builder.toString()
    }
}

//运算符重载
open class TagClass(tagName: String) : Tag(tagName = tagName) {
    operator fun String.unaryPlus() {
        element += TextElement(this)
    }

    operator fun String.unaryMinus() {
        element += TextElement(this)
    }
}

class HTML : TagClass("html") {
    fun head(action: Head.() -> Unit) {
        val newHead = Head()
        newHead.action()
        element += newHead
    }

    fun body(action: Body.() -> Unit) {
        val newBody = Body("body")
        newBody.action()
        element += newBody
    }
}


class Head : TagClass("head") {
    fun title(action: Title.() -> Unit) {
        val newTitle = Title()
        newTitle.action()
        element.add(newTitle)
    }
}

class Title() : TagClass("title")

open class Body(tagName: String) : TagClass(tagName) {
    fun h1(action: H1. () -> Unit) {
        val newH1 = H1()
        newH1.action()
        element += newH1
    }

    fun p(action: P.() -> Unit) {
        val newP = P()
        newP.action()
        element += newP
    }

    fun a(href: String, action: A.() -> Unit) {
        val newA = A()
        newA.href = href
        newA.action()
        element += newA
    }

    fun b(action: B.() -> Unit) {
        val newB = B()
        newB.action()
        element += newB
    }

    fun ul(action: UL.() -> Unit) {
        val newUL = UL()
        newUL.action()
        element += newUL
    }

//    fun li(action: Body.() -> Unit) {
//
//    }
}

class H1 : Body("h1")
class P : Body("p")
class A : Body("a") {
    var href: String
        get() = attributes["href"]!!
        set(value) {
            attributes["href"] = value
        }
}

class B : Body("b")

class UL : Body("ul") {
    fun li(action: LI.() -> Unit) {
        val newLi = LI()
        newLi.action()
        element.add(newLi)
    }
}

class LI : Body("li")

fun html(action: HTML.() -> Unit): HTML {
    val htmlObj = HTML()
    htmlObj.action()
    return htmlObj
}