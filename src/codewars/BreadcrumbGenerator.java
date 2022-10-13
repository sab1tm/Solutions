package codewars;

// As breadcrumb menùs are quite popular today, I won't digress much on explaining them, leaving the wiki link to do all the dirty work in my place.
// What might not be so trivial is instead to get a decent breadcrumb from your current url. For this kata, your purpose is to create a function that takes a url, strips the first part (labelling it always HOME) and then builds it making each element but the last a <a> element linking to the relevant path; last has to be a <span> element getting the active class.
// All elements need to be turned to uppercase and separated by a separator, given as the second parameter of the function; the last element can terminate in some common extension like .html, .htm, .php or .asp; if the name of the last element is index.something, you treat it as if it wasn't there, sending users automatically to the upper level folder.
// A few examples can be more helpful than thousands of words of explanation, so here you have them:
// Solution.generate_bc("mysite.com/pictures/holidays.html", " : ").equals( '<a href="/">HOME</a> : <a href="/pictures/">PICTURES</a> : <span class="active">HOLIDAYS</span>' );
// Solution.generate_bc("www.codewars.com/users/GiacomoSorbi", " / ").equals( '<a href="/">HOME</a> / <a href="/users/">USERS</a> / <span class="active">GIACOMOSORBI</span>' );
// Solution.generate_bc("www.microsoft.com/docs/index.htm", " * ").equals( '<a href="/">HOME</a> * <span class="active">DOCS</span>' );
// Seems easy enough?
// Well, probably not so much, but we have one last extra rule: if one element (other than the root/home) is longer than 30 characters, you have to shorten it, acronymizing it (i.e.: taking just the initials of every word); url will be always given in the format this-is-an-element-of-the-url and you should ignore words in this array while acronymizing: ["the","of","in","from","by","with","and", "or", "for", "to", "at", "a"]; a url composed of more words separated by - and equal or less than 30 characters long needs to be just uppercased with hyphens replaced by spaces.
// Ignore anchors (www.url.com#lameAnchorExample) and parameters (www.url.com?codewars=rocks&pippi=rocksToo) when present.
// Examples:
// Solution.generate_bc("mysite.com/very-long-url-to-make-a-silly-yet-meaningful-example/example.htm", " > ").equals( '<a href="/">HOME</a> > <a href="/very-long-url-to-make-a-silly-yet-meaningful-example/">VLUMSYME</a> > <span class="active">EXAMPLE</span>' );
// Solution.generate_bc("www.very-long-site_name-to-make-a-silly-yet-meaningful-example.com/users/giacomo-sorbi", " + ").equals( '<a href="/">HOME</a> + <a href="/users/">USERS</a> + <span class="active">GIACOMO SORBI</span>' );
// You will always be provided valid url to webpages in common formats, so you probably shouldn't bother validating them.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class BreadcrumbGenerator {

    static final List<String> ignoreWords = new ArrayList<>(Arrays.asList("the", "of", "in", "from", "by", "with", "and", "or", "for", "to", "at", "a"));
    static final List<String> pageExtensions = new ArrayList<>(Arrays.asList(".html", ".htm", ".php", ".asp"));

    public static void main(String[] args) {
        String input = "www.agcpartners.co.uk/city/astana/users/index.html?id=1";

        String result = generate_bc(input, " / ");

        // should be <a href="/">HOME</a> / <a href="/very-long-url-to-make-a-silly-yet-meaningful-example/">VLUMSYME</a> / <span class="active">EXAMPLE</span>
        System.out.println(result);
    }

    public static String generate_bc(String url, String separator) {
        StringJoiner joiner = new StringJoiner(separator);

        String[] parts = removeProtocol(url).split("/");

        parts[0] = "";

        if (isIndexPage(parts[parts.length - 1]))
            parts = Arrays.copyOf(parts, parts.length - 1);

        for (int i = parts.length - 1; i >= 0; i--) {
            if (i == parts.length - 1)
                parts[i] = spanBuilder(parts[i]);
            else
                parts[i] = hrefBuilder(parts[i]);
        }

        for (String part : parts)
            joiner.add(part);

        return joiner.toString();
    }

    private static String removeProtocol(String url) {
        return url.replaceAll("(https?:\\/\\/)", "");
    }

    private static boolean isIndexPage(String node) {
        return "index".equals(removeExtension(removeAdditional(node)));
    }

    private static String spanBuilder(String node) {
        if (node.isBlank())
            node = "home";
        return tagBuilder("span", "class=\"active\"", node);
    }

    private static String hrefBuilder(String node) {
        StringBuilder attribute = new StringBuilder("href=\"/");
        if (!node.isBlank())
            attribute.append(node).append("/");
        else
            node = "home";
        attribute.append("\"");

        return tagBuilder("a", attribute.toString(), node);
    }

    private static String tagBuilder(String name, String attribute, String value) {
        StringBuilder tag = new StringBuilder("<");
        tag.append(name).append(" ");
        tag.append(attribute).append(">");
        tag.append(processing(value));
        tag.append("</").append(name).append(">");
        return tag.toString();
    }

    private static String processing(String node) {
        return acronym(removeExtension(removeAdditional(node)))
                .toUpperCase();
    }

    private static String acronym(String node) {
        if (node.length() > 30) {
            StringBuilder result = new StringBuilder();
            String[] parts = node.split("-");
            for (String part : parts)
                if (!ignoreWords.contains(part))
                    result.append(part.charAt(0));
            node = result.toString();
        }
        return node.replaceAll("-", " ");
    }

    private static String removeAdditional(String node) {
        return node.replaceAll("([?#].+)", "");
    }

    private static String removeExtension(String node) {
        int pos = node.lastIndexOf('.');
        if (pos > -1)
            return node.substring(0, pos);
        return node;
    }
}


