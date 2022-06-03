package Fichas.Ficha4.Ex4;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FBFeed {

    /*
    (b) A classe FBFeed implementa a timeline e deve implementar, além dos métodos usuais, os métodos que permitam:
     */

    private List<FBPost> posts;

    // CONSTRUTORES //

    public FBFeed(){
        this.posts = new ArrayList<>();
    }

    public FBFeed(List<FBPost> posts) {
        setPosts(posts);
    }

    public FBFeed(FBFeed feed) {
        setPosts(feed.getPosts());
    }

    // GETTER'S & SETTER'S //

    public List<FBPost> getPosts() {
        return this.posts.stream().map(FBPost::clone).collect(Collectors.toList());
    }

    public void setPosts(List<FBPost> posts) {
        this.posts = posts.stream().map(FBPost::clone).collect(Collectors.toList());
    }

    //MÉTODOS//

    // i. Determinar o número de posts de um user,

    public int nrPosts(String user){
        return this.postsOf(user).size();
    }

    //ii. Determinar a lista de posts de um user,

    public List<FBPost> postsOf(String user){
        return this.posts.stream().filter(post -> (post.getUserName().equals(user)))
                .collect(Collectors.toList());
    }

    //iii. Determinar a lista de posts de um user num determinado intervalo de tempo,

    public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim){
        return this.posts.stream().filter(post -> (post.getUserName().equals(user)
                        && post.getInstantCreated().compareTo(inicio) > 0
                        && post.getInstantCreated().compareTo(fim) < 0))
                .collect(Collectors.toList());
    }

    //iv. Obter um post dado o seu identificador,

    public FBPost getPost(int id){
        for(FBPost post : this.posts)
            if(post.getID() == id)
                return post;
        return null;
    }


    //v. Inserir um comentário num post,

    public void comment(FBPost post, String comentario){
        post.getComments().add(comentario);
    }

    //vi. Inserir um comentário num post,

    public void comment(int postid, String comentario){
        comment(getPost(postid), comentario);
    }

    //vii. Adicionar um like a um post,

    public void like(FBPost post){
        post.setLikes(post.getLikes() + 1);
    }

    //viii. Adicionar um like a um post,

    void like(int postid){
        FBPost post = getPost(postid);
        like(post);

        //like(getPost(postid));
    }


    //ix. Determinar a lista dos 5 posts (identificador) com mais comentários public List<Integer> top5Comments().
    //Desenvolva uma versão com iteradores externos e outra com iteradores internos.

    public List<Integer> top5CommentsExt() {
        ArrayList<FBPost> copy = new ArrayList<>(this.posts);
        List<Integer> top5 = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            FBPost mostCommented = null;
            for(FBPost post : copy)
                if(mostCommented == null || mostCommented.getComments().size() < post.getComments().size())
                    mostCommented = post;
            top5.add(mostCommented.getID());
            copy.remove(mostCommented);
        }
        return top5;
    }

    public List<Integer> top5CommentsInt() {
        return this.posts.stream()
                .sorted((p1, p2) -> p2.getComments().size() - p1.getComments().size())
                .limit(5)
                .map(FBPost::getID)
                .collect(Collectors.toList());
    }

    //OUTROS MÉTODOS QUE TODAS AS CLASSES DEVEM CONTER//

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FBFeed fbFeed = (FBFeed) o;
        return this.posts.equals(fbFeed.posts);
    }

    public int hashCode() {
        return Objects.hash(posts);
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("FBFeed {\n");
        sb.append(posts).append('\n');
        sb.append("\n}");
        return sb.toString();
    }

    public FBFeed clone() {
        return new FBFeed(this);
    }
}


